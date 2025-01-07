import React, { useState } from "react";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import axios from "axios";
import { isValidUrl } from "../utils/URLComponentHelper.ts";
import { Toaster } from "../molecules/Toaster.tsx";

export const URLComponent = ({ 
  setShowRecent,
  urlList,
  setUrlList
 }) => {
  const [longUrl, setLongUrl] = useState("")
  const [alias, setAlias] = useState("")
  const [shortUrl, setShortUrl] = useState("")
  const [toastMessage, setToastMessage] = useState('')

  const postUrlData = async () => {
    if (!longUrl || !isValidUrl(longUrl)) {
      setToastMessage("Please enter a valid URL")
      return
    }
    
    try {
      const postData = { long_url: longUrl, alias }
      const { data } = await axios.post("/api/v1/url", postData)
      
      setShortUrl(data.short_url)
      setUrlList([...urlList, data])
    } catch (error) {
      setToastMessage('There was an error creating the shortened URL')
    }
  }

  const resetForm = () => {
    setLongUrl("");
    setAlias("");
    setShortUrl("")
  }

  return (
    <>
    <Toaster message={toastMessage} onClose={() => setToastMessage('')} />
    <Card className="shadow p-4">
      <Card.Body>
        <Form>
          <Form.Group className="mb-3" controlId="longUrl">
            <Form.Label className="form-label-custom">Shorten a long URL</Form.Label>
            <Form.Control
              type="text"
              placeholder="https://example.com"
              className="custom-placeholder"
              value={longUrl}
              onChange={(e) => setLongUrl(e.target.value)}
            />
          </Form.Group>
          {shortUrl ? <>
            <Form.Group>
              <Form.Label className="form-label-custom">Shortened URL</Form.Label>
                <Form.Control
                  type="text"
                  value={shortUrl}
                />
            </Form.Group>
            <Button
              variant="info" 
              size="lg" 
              className="button-text-custom mt-3 mx-2"
              onClick={() => setShowRecent(true)}
            >
              My Urls
            </Button>
            <Button
              variant="success" 
              size="lg" 
              className="button-text-custom mt-3 mx-2"
              onClick={resetForm}
            >
              Shorten another
            </Button>
          </>
          : <>
              <Form.Group className="mb-4" controlId="alias">
                <Form.Label className="form-label-custom">Customize your link</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="my-custom-alias"
                  className="custom-placeholder"
                  value={alias}
                  onChange={(e) => setAlias(e.target.value)}
                />
              </Form.Group>
              <div className="d-grid gap-2">
                <Button 
                  variant="success" 
                  size="lg" 
                  className="button-text-custom"
                  onClick={postUrlData}
                >
                  Shorten URL
                </Button>
              </div>
           </>
          }
        </Form>
      </Card.Body>
    </Card>
    </>
  )
}
