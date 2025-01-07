import { useEffect, useState } from 'react';
import '../App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import axios from 'axios';
import { MenuButtons } from '../atoms/MenuButtons.tsx';
import { URLComponent } from '../templates/URLComponent.tsx';

function App() {
  const [urlList, setUrlList] = useState([])
  const [showRecent, setShowRecent] = useState(false)
  const [user, setUser] = useState(null)

  const getAllUrls = async () => {
    try {
      const { data } = await axios.get("/api/v1/url")
      setUrlList(data)
    } catch (error) {
      console.error("Error fetching URLs:", error)
    }
  }

  const getUrlsByUser = async (userId) => {
    try {
      const { data } = await axios.get(`/api/v1/url/${userId}`)
      setUrlList(data)
    } catch (error) {
      console.error("Error fetching URLs:", error)
    }
  }

  useEffect(() => {
    if (user) {
      getUrlsByUser(user?.userId)
    } else {
      getAllUrls()
    }
  }, [user, setUrlList])

  return (
    <div className="App background-container d-flex flex-column align-items-center">
      <Container className="py-3">
        <Row className="mb-4 justify-content-center">
          <Col md="auto">
            <h1 className="text-center page-title">URL Shortener</h1>
            {user && (
              <h1 className="text-center page-title welcome-message">
                  Welcome Back, <span className="username">{user?.email}</span>!
              </h1>
            )}
          </Col>
        </Row>
        <Row className="g-3 justify-content-center">
          <Col md="auto" className="text-center">
            <MenuButtons 
              className="mb-3"
              urlList={urlList} 
              setUrlList={setUrlList}
              setUser={setUser}
              user={user}
            />
            <div className="mt-2"> 
              <URLComponent
                setShowRecent={setShowRecent}
                urlList={urlList}
                setUrlList={setUrlList}
              />
            </div>
          </Col>
        </Row>
      </Container>
    </div>
  )
}

export default App;
