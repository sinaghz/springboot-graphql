```graphql
mutation{
    newBook(input: {
        name: "Screen Record",
        pageCount: "300"
    }){
        name
        pageCount
    }
}
```

```graphql
query {
 allBook{
   id
   name
   pageCount
 }
 }
```