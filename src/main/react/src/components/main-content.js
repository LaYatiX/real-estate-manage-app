import React from "react"
import TopNav from "./top-nav"
import Footer from "./footer"

const MainContent = ({children}) => {
  return (
      <div id="content-wrapper" className="d-flex flex-column">
        <div id="content">
          <TopNav/>
          <main>
            {children}
          </main>
        </div>
        <Footer/>
      </div>
  )
}

export default MainContent