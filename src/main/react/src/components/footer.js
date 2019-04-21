import React from "react"

const Footer = () => {
  return (
    <footer className="sticky-footer bg-white">
      <div className="container my-auto">
        <div className="copyright text-center my-auto">
          <span>Copyright Grzegorz Piwosz © Estate App {new Date().getFullYear()}</span>
        </div>
      </div>
    </footer>
  )
}

export default Footer