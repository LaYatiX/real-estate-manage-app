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
                  id
                  name
                  surname
                  pesel
                  address
              }
            }
        }
    `}
      render={data => (
        <div>
          <ul>
            {data.api.getUsers.map((data)=>{
              return <ItemList key={data.id}>{data.name} {data.surname} - {data.pesel}</ItemList>
            })}
          </ul>
        </div>
      )}
    />
  )
}

export default UsersList