import React, { useState } from "react";
import Offcanvas from 'react-bootstrap/Offcanvas';
import Card from 'react-bootstrap/Card';
import { calculateDaysAgo } from "../utils/URLComponentHelper.ts";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import axios from "axios";

export const RecentUrlList = ({
  showRecent,
  handleRecentClose,
  urlList,
  setUrlList
}) => {
  const [editingAlias, setEditingAlias] = useState(null)
  const [newAlias, setNewAlias] = useState('')

  const handleEditClick = (shortUrl) => {
    setEditingAlias(shortUrl)
    setNewAlias('')
  }

  const updateUrlAlias = async (short_url, newAlias) => {
    try {
      const response = await axios.put('/api/v1/url', {
        short_url: short_url,
        new_alias: newAlias,
      });
  
      const updatedUrl = response.data
  
      setUrlList((prevUrlList) => {
        return prevUrlList.map((url) =>
          url.url_id === updatedUrl.url_id
            ? { ...url, short_url: updatedUrl.short_url, alias: updatedUrl.new_alias }
            : url
        );
      })
    } catch (error) {
      console.error('Error updating URL alias:', error);
    }
  }

  const handleUpdateAlias = async (short_url, newAlias) => {
    try {
      await updateUrlAlias(short_url, newAlias);
      setEditingAlias(null)
    } catch (error) {
      console.error('Failed to update alias:', error)
    }
  }

  return (
    <Offcanvas show={showRecent} onHide={handleRecentClose} placement="end">
      <Offcanvas.Header closeButton>
        <Offcanvas.Title className="text-center sign-in-title">
          Your Recent Shortened URLs
        </Offcanvas.Title>
      </Offcanvas.Header>
      <Offcanvas.Body>
        {urlList?.length > 0 ? (
          urlList.map((url, index) => (
            <Card className="p-3 mb-3 shadow-sm rounded" key={index}>
              <Card.Title className="card-title-custom">{url.short_url}</Card.Title>
              <Card.Text className="card-text-custom">{url.long_url}</Card.Text>
              <Card.Text className="card-text-custom">
                {`${url.total_clicks ? url.total_clicks : 0} clicks | ${
                  url.last_accessed
                    ? calculateDaysAgo(url.last_accessed)
                    : 'never'
                }`}
              </Card.Text>
              {editingAlias === url.short_url ? (
                <Form>
                  <Form.Group className="mb-3" controlId={`updateAlias-${index}`}>
                    <Form.Label className="form-label-custom">New Alias</Form.Label>
                    <InputGroup>
                      <Form.Control
                        type="text"
                        placeholder="Enter new alias"
                        className="custom-placeholder"
                        value={newAlias}
                        onChange={(e) => setNewAlias(e.target.value)}
                      />
                      <Button
                        variant="success"
                        onClick={() => handleUpdateAlias(url.short_url, newAlias)}
                      >
                        Save
                      </Button>
                      <Button
                        variant="outline-secondary"
                        onClick={() => setEditingAlias(null)}
                      >
                        Cancel
                      </Button>
                    </InputGroup>
                  </Form.Group>
                </Form>
              ) : (
                <Button
                  size="sm"
                  variant="outline-secondary" 
                  onClick={() => handleEditClick(url.short_url)}
                >
                  Edit Alias
                </Button>
              )}
            </Card>
          ))
        ) : (
          <p className="paragraph-custom">No recent URLs found.</p>
        )}
        <p className="paragraph-custom">No more recent URLs in your history</p>
      </Offcanvas.Body>
    </Offcanvas>
  )
}
