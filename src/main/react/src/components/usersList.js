import React from "react"
import { graphql, StaticQuery } from "gatsby"
import styled from "styled-components"

const UsersList = () => {

  const ItemList = styled.li`
    background-color: aqua;
  `

  return (
    <StaticQuery
      query={graphql`
        query {
            api{
              getUsers {
                  name
                  pesel
                  username
                  active
                  address
              }
            }
        }
    `}
      render={data => (
        <div>
          <ul>
            {data.api.getUsers.map((data)=>(
              <ItemList>{data.name}</ItemList>
            ))}
          </ul>
        </div>
      )}
    />
  )
}

export default UsersList