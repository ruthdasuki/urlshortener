import React from "react"
import Toast from 'react-bootstrap/Toast'

export const Toaster = ({
    message,
    onClose
}) => {

    return (
        <div className="toaster-container">
            <Toast onClose={onClose} show={message !== ''} autohide>
                <Toast.Header className="toast-warning-header">
                    <strong className="me-auto">Warning</strong>
                </Toast.Header>
                <Toast.Body className="toast-warning-body">{message}</Toast.Body>
            </Toast>
        </div>
    )
}