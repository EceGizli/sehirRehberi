import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [places, setPlaces] = useState([]);
  const [cities, setCities] = useState([]);
  const [categories, setCategories] = useState([]);
  const [comments, setComments] = useState([]);
  const [ratings, setRatings] = useState([]);
  const [users, setUsers] = useState([]);

  const [search, setSearch] = useState("");
  const [selectedCity, setSelectedCity] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("");

  const [commentText, setCommentText] = useState({});
  const [score, setScore] = useState({});

  const [email, setEmail] = useState("");
  const [currentUser, setCurrentUser] = useState(null);
  const [message, setMessage] = useState("");
  const [showLogin, setShowLogin] = useState(false);

  const imageMap = {
    "Galata Kulesi": "/images/galatakulesi.jpg",
    Ayasofya: "/images/ayasofya.jpg",
    "Sultanahmet Camii": "/images/sultanahmet.jpg",
    "Kız Kalesi": "/images/kizkalesi.jpg",
    "Soli Pompeipolis Antik Kenti": "/images/soli.jpg",
    "Eymir Gölü": "/images/eymir.jpg",
    Kültürpark: "/images/kulturpark.jpg",
    "Konyaaltı Plajı": "/images/konyaalti.jpg",
    "Lara Plajı": "/images/lara.jpg",
    "Kaputaş Plajı": "/images/kaputas.jpg",
    "Saat Kulesi": "/images/saatkulesi.jpg",
  };

  useEffect(() => {
    fetch("http://localhost:8080/places")
      .then((res) => res.json())
      .then((data) => setPlaces(data));

    fetch("http://localhost:8080/city/listele")
      .then((res) => res.json())
      .then((data) => setCities(data));

    fetch("http://localhost:8080/category/listele")
      .then((res) => res.json())
      .then((data) => setCategories(data));

    fetch("http://localhost:8080/comment/listele")
      .then((res) => res.json())
      .then((data) => setComments(data));

    fetch("http://localhost:8080/rating/listele")
      .then((res) => res.json())
      .then((data) => setRatings(data));

    fetch("http://localhost:8080/user/listele")
      .then((res) => res.json())
      .then((data) => setUsers(data));
  }, []);

  const login = () => {
    const foundUser = users.find((user) => user.email === email);

    if (foundUser) {
      setCurrentUser(foundUser);
      setMessage("Giriş başarılı.");
      setShowLogin(false);
    } else {
      setMessage("Bu email kayıtlı değil.");
    }
  };

  const register = () => {
    const foundUser = users.find((user) => user.email === email);

    if (foundUser) {
      setMessage("Bu email zaten kayıtlı.");
      return;
    }

    fetch("http://localhost:8080/user/ekle", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: "Yeni",
        lastname: "Kullanıcı",
        email: email,
      }),
    })
      .then((res) => res.json())
      .then((newUser) => {
        setUsers([...users, newUser]);
        setCurrentUser(newUser);
        setMessage("Kayıt başarılı.");
        setShowLogin(false);
      });
  };

  const logout = () => {
    setCurrentUser(null);
    setEmail("");
    setMessage("");
  };

  const filteredPlaces = places.filter((place) => {
    const searchMatch =
      place.placeName.toLowerCase().includes(search.toLowerCase()) ||
      place.address.toLowerCase().includes(search.toLowerCase());

    const cityMatch =
      selectedCity === "" || String(place.cityid) === String(selectedCity);

    const categoryMatch =
      selectedCategory === "" ||
      String(place.categoryid) === String(selectedCategory);

    return searchMatch && cityMatch && categoryMatch;
  });

  const getPlaceComments = (placeId) => {
    return comments.filter((comment) => comment.placeId === placeId);
  };

  const getPlaceRatings = (placeId) => {
    return ratings.filter((rating) => rating.placeId === placeId);
  };

  const getAverageScore = (placeId) => {
    const placeRatings = getPlaceRatings(placeId);

    if (placeRatings.length === 0) {
      return "Henüz puan yok";
    }

    const total = placeRatings.reduce((sum, rating) => sum + rating.score, 0);
    return (total / placeRatings.length).toFixed(1);
  };

  const addComment = (placeId) => {
    if (!currentUser || !commentText[placeId]) return;

    fetch("http://localhost:8080/comment/ekle", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        userId: currentUser.userid,
        placeId: placeId,
        text: commentText[placeId],
      }),
    })
      .then((res) => res.json())
      .then((newComment) => {
        setComments([...comments, newComment]);
        setCommentText({
          ...commentText,
          [placeId]: "",
        });
      });
  };

  const addRating = (placeId) => {
    if (!currentUser || !score[placeId]) return;

    fetch("http://localhost:8080/rating/ekle", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        userId: currentUser.userid,
        placeId: placeId,
        score: Number(score[placeId]),
      }),
    })
      .then((res) => res.json())
      .then((newRating) => {
        setRatings([...ratings, newRating]);
        setScore({
          ...score,
          [placeId]: "",
        });
      });
  };

  const deleteComment = (commentid) => {
    fetch(`http://localhost:8080/comment/sil/${commentid}`, {
      method: "DELETE",
    }).then(() => {
      setComments(comments.filter((comment) => comment.commentid !== commentid));
    });
  };

  const deleteRating = (ratingid) => {
    fetch(`http://localhost:8080/rating/sil/${ratingid}`, {
      method: "DELETE",
    }).then(() => {
      setRatings(ratings.filter((rating) => rating.ratingid !== ratingid));
    });
  };

  const goHome = () => {
    setSearch("");
    setSelectedCity("");
    setSelectedCategory("");
    window.scrollTo({ top: 0, behavior: "smooth" });
  };

  return (
    <div className="container">
      <div className="top-bar">
        <h1 onClick={goHome}>ŞEHİR REHBERİ</h1>

        <div className="login-area">
          {currentUser ? (
            <div className="active-user">
              <span>{currentUser.email}</span>
              <button onClick={logout}>Çıkış Yap</button>
            </div>
          ) : (
            <button
              className="login-toggle"
              onClick={() => setShowLogin(!showLogin)}
            >
              Giriş Yap / Kayıt Ol
            </button>
          )}

          {showLogin && !currentUser && (
            <div className="login-panel">
              <input
                type="email"
                placeholder="Email adresiniz"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />

              <div className="login-buttons">
                <button onClick={login}>Giriş Yap</button>
                <button onClick={register}>Kayıt Ol</button>
              </div>

              {message && <p>{message}</p>}
            </div>
          )}
        </div>
      </div>

      <input
        type="text"
        placeholder="Mekan veya adres ara..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
        className="search"
      />

      <div className="filters">
        <select
          value={selectedCity}
          onChange={(e) => {
            setSelectedCity(e.target.value);
            setSelectedCategory("");
          }}
        >
          <option value="">Tüm Şehirler</option>

          {cities.map((city) => (
            <option key={city.cityid} value={city.cityid}>
              {city.cityname}
            </option>
          ))}
        </select>

        <select
          value={selectedCategory}
          onChange={(e) => setSelectedCategory(e.target.value)}
        >
          <option value="">Tüm Kategoriler</option>

          {categories.map((category) => (
            <option key={category.categoryid} value={category.categoryid}>
              {category.categoryname}
            </option>
          ))}
        </select>
      </div>

      <div className="place-list">
        {filteredPlaces.map((place) => (
          <div className="card" key={place.placeId}>
            <img
              src={imageMap[place.placeName]}
              alt={place.placeName}
              className="card-image"
            />

            <div className="card-content">
              <h2>{place.placeName}</h2>

              <p>
                <b>Adres:</b> {place.address}
              </p>

              <p>
                <b>Açıklama:</b> {place.description}
              </p>

              <div className="rating-box">
                Ortalama Puan:
                <span> {getAverageScore(place.placeId)}</span>
              </div>

              <div className="comments">
                <h3>Yorumlar</h3>

                {getPlaceComments(place.placeId).length === 0 ? (
                  <p className="empty-comment">Henüz yorum yapılmadı.</p>
                ) : (
                  getPlaceComments(place.placeId).map((comment) => (
                    <div key={comment.commentid} className="comment-box">
                      <p className="comment">{comment.text}</p>

                      {currentUser &&
                        comment.userId === currentUser.userid && (
                          <button
                            className="delete-btn"
                            onClick={() => deleteComment(comment.commentid)}
                          >
                            Sil
                          </button>
                        )}
                    </div>
                  ))
                )}
              </div>

              {currentUser && (
                <>
                  <div className="form-area">
                    <input
                      type="text"
                      placeholder="Yorum yaz..."
                      value={commentText[place.placeId] || ""}
                      onChange={(e) =>
                        setCommentText({
                          ...commentText,
                          [place.placeId]: e.target.value,
                        })
                      }
                    />

                    <button onClick={() => addComment(place.placeId)}>
                      Yorum Ekle
                    </button>
                  </div>

                  <div className="form-area">
                    <select
                      value={score[place.placeId] || ""}
                      onChange={(e) =>
                        setScore({
                          ...score,
                          [place.placeId]: e.target.value,
                        })
                      }
                    >
                      <option value="">Puan Seç</option>
                      <option value="1">1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                      <option value="4">4</option>
                      <option value="5">5</option>
                    </select>

                    <button onClick={() => addRating(place.placeId)}>
                      Puan Ver
                    </button>
                  </div>

                  <div className="ratings">
                    <h3>Verilen Puanlar</h3>

                    {getPlaceRatings(place.placeId).length === 0 ? (
                      <p className="empty-comment">Henüz puan verilmedi.</p>
                    ) : (
                      getPlaceRatings(place.placeId).map((rating) => (
                        <div key={rating.ratingid} className="rating-item">
                          <span>{rating.score} puan</span>

                          {currentUser &&
                            rating.userId === currentUser.userid && (
                              <button
                                className="delete-btn"
                                onClick={() => deleteRating(rating.ratingid)}
                              >
                                Sil
                              </button>
                            )}
                        </div>
                      ))
                    )}
                  </div>
                </>
              )}

              {!currentUser && (
                <p className="login-warning">
                  Yorum yapmak ve puan vermek için giriş yapın.
                </p>
              )}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;