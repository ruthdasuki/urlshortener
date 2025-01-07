import React, { useState } from "react";
import Offcanvas from 'react-bootstrap/Offcanvas';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import axios from "axios";
import { Toaster } from "../molecules/Toaster.tsx";
import { isValidEmail } from "../utils/URLComponentHelper.ts";

export const SignInForm = ({
    showSignInForm,
    handleSignInFormClose,
    setUser
}) => {
    const [showPassword, setShowPassword] = useState(false)
    const [toastMessage, setToastMessage] = useState('')
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    
    const togglePasswordVisibility = () => {
        setShowPassword((prev) => !prev);
    }

    const login = async () => {
        if (!isValidEmail(email)) {
            setToastMessage("Please enter a valid email")
            return
        }
        
        try {
            const postData = { 
                email: email,
                password: password
            }
            const { data } = await axios.post("/auth/login", postData)
            setUser(data)
        } catch (error) {
            if (error.response && error.response.data) {
                setToastMessage(error.response.data.message)
            } else {
                setToastMessage('There was an error creating user')
            }
        }
    }

    return (
        <>
        <Toaster message={toastMessage} onClose={() => setToastMessage('')} />
        <Offcanvas show={showSignInForm} onHide={handleSignInFormClose} placement="end">
            <Offcanvas.Header closeButton>
                <Offcanvas.Title className="text-center sign-in-title">Welcome to URL Shortener</Offcanvas.Title>
            </Offcanvas.Header>
                <Offcanvas.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label className="form-label-custom">Email</Form.Label>
                            <Form.Control 
                                type="email"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                            />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label className="form-label-custom">Password</Form.Label>
                            <InputGroup>
                                <Form.Control 
                                    type={showPassword ? "text" : "password"} 
                                    placeholder="Enter your password"
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                />
                                <Button 
                                    variant="outline-secondary" 
                                    onClick={togglePasswordVisibility}
                                >
                                    {showPassword ? "Hide" : "Show"}
                                </Button>
                            </InputGroup>
                        </Form.Group>

                        <Button 
                            variant="success" 
                            className="button-text-custom"
                            onClick={login}
                        >
                            Sign In
                        </Button>
                    </Form>
                </Offcanvas.Body>
        </Offcanvas>
        </>
    )
}