import React, { useState } from "react";
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import { RecentUrlList } from "../organisms/RecentUrlList.tsx";
import { SignUpForm } from "../organisms/SignUpForm.tsx";
import { SignInForm } from "../organisms/SignInForm.tsx";

export const MenuButtons = ({ 
    urlList,
    setUrlList,
    setUser,
    user
  }) => {    
  // recent urls
  const [showRecent, setRecent] = useState(false)
  const handleRecentClose = () => setRecent(false)
  const handleRecentShow = () => setRecent(true)

  // sign up form
  const [showSignUpForm, setSignUpForm] = useState(false)
  const handleSignUpFormClose = () => setSignUpForm(false)
  const handleSignUpFormShow = () => setSignUpForm(true)

  // sign in form
  const [showSignInForm, setSignInForm] = useState(false)
  const handleSignInFormClose = () => setSignInForm(false)
  const handleSignInFormShow = () => setSignInForm(true)

  const logout = () => {
    window.localStorage.removeItem('jwtToken')
    setUser(null)
  }

    return (
      <>
        <ButtonGroup aria-label="Basic example">
          <Button variant="success" className="button-text-custom" onClick={handleRecentShow}>My URLs</Button>
          <Button variant="success" className="button-text-custom" onClick={handleSignUpFormShow}>Sign Up</Button>
          <Button variant="success" className="button-text-custom" onClick={handleSignInFormShow}>Sign In</Button>
          {user && <Button variant="success" className="button-text-custom" onClick={logout}>Log Out</Button>}
        </ButtonGroup>
        
        <RecentUrlList
          showRecent={showRecent}
          handleRecentClose={handleRecentClose}
          urlList={urlList}
          setUrlList={setUrlList}
        />

        <SignUpForm
          showSignUpForm={showSignUpForm}
          handleSignUpFormClose={handleSignUpFormClose}
        />

        <SignInForm
          showSignInForm={showSignInForm}
          handleSignInFormClose={handleSignInFormClose}
          setUser={setUser}
        />
      </>
    )
}
