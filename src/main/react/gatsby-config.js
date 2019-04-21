const proxy = require("http-proxy-middleware")
const fs = require("fs")
const { buildSchema, buildClientSchema } = require("graphql")

module.exports = {
  siteMetadata: {
    title: `Estate management app`,
    description: `Estate management app`,
    author: `Grzegorz Piwosz`,
  },
  developMiddleware: app => {
    app.use(
      '/graphql',
      proxy({
        target: 'http://localhost:9000'
      })
    )
  },
  plugins: [
    `gatsby-plugin-sass`,
    {
      resolve: "gatsby-source-graphql",
      options: {
        // This type will contain remote schema Query type
        typeName: "API",
        // This is field under which it's accessible
        fieldName: "api",
        url: "http://localhost:9000/graphql",
        refetchInterval: 60,
        createSchema: async () => {
          const json = fs.readFileSync(`${__dirname}/../resources/graphql/query.graphql`).toString()
          return buildSchema(json)
        },
      },
    },
    `gatsby-plugin-react-helmet`,
    {
      resolve: `gatsby-source-filesystem`,
      options: {
        name: `images`,
        path: `${__dirname}/src/images`,
      },
    },
    `gatsby-transformer-sharp`,
    `gatsby-plugin-sharp`,
    `gatsby-plugin-styled-components`,
    {
      resolve: `gatsby-plugin-manifest`,
      options: {
        name: `gatsby-starter-default`,
        short_name: `starter`,
        start_url: `/`,
        background_color: `#663399`,
        theme_color: `#663399`,
        display: `minimal-ui`,
        icon: `src/images/gatsby-icon.png`, // This path is relative to the root of the site.
      },
    },
    // this (optional) plugin enables Progressive Web App + Offline functionality
    // To learn more, visit: https://gatsby.dev/offline
    // 'gatsby-plugin-offline',
  ],
}
