import React from "react"
import Layout from "../components/layout"
import UsersList from "../components/usersList"
import { Link } from "gatsby"

const Users = () => (
  <Layout>
    <UsersList/>
    <Link to={'/'}>To site</Link>
  </Layout>
)

export default Users

