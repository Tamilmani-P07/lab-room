const xhttp = new XMLHttpRequest();


 function getBook() {

    xhttp.onreadystatechange = function() {
        book = this.responseText;
        console.log(book);
        if (this.readyState == 4 && this.status == 200) {
        displayItems(JSON.parse(book));}
      

    }
    xhttp.open("GET", "http://localhost:9090/books");
    xhttp.send();
  }
  function displayItems(data) {
    const tBody = document.getElementById("books");
    const button = document.createElement("button");


    data.forEach((book) => {
      let editButton = button.cloneNode(false);
      editButton.innerText = "Edit";
      editButton.setAttribute("onclick", `editItem(${book.id})`);

      let delButton = button.cloneNode(false);
      delButton.innerText = "Delete";
      delButton.setAttribute("onclick", `deleteItem(${book.id})`);

      console.log(book.title);
      let tr = tBody.insertRow();

      let td1 = tr.insertCell(0);
      let id = document.createTextNode(book.id);
      td1.appendChild(id);

      let td2 = tr.insertCell(1);
      let title = document.createTextNode(book.title);
      td2.appendChild(title);

      let td3 = tr.insertCell(2);
      let price = document.createTextNode(book.price);
      td3.appendChild(price);

      let td4= tr.insertCell(3);
      let a_id = document.createTextNode(book.author_name);
      td4.appendChild(a_id);

      let td5 = tr.insertCell(4);
      td5.appendChild(editButton);

      let td6 = tr.insertCell(5);
      td6.appendChild(delButton);

  });
  
  }
  function editItem(id) {
    document.getElementById("my").innerHTML = "Update";
 
    const item = books.find((item) => item.id === id);
    document.getElementById("title").value = item.title;
    document.getElementById("author").value = item.author;
    document.getElementById("price").value = item.price;
    document.getElementById("author_id").value = item.author_id;
    updateIndex = id;
 
}

  function postBook(){
   
       let book={
        id:document.getElementById("id").value,
        title:document.getElementById("title").value,
        price:document.getElementById("price").value,
        author_id:document.getElementById("author_id").value
       }
       let stringBook=JSON.stringify(book);
       console.log(stringBook);
       document.getElementById("demo").innerHTML = this.responseText;
        console.log(this.responseText);
      
    
    xhttp.open("POST", "http://localhost:9090/books");
    xhttp.send(stringBook);
  }






























































  
// function loadGet() {
//     xhttp.onreadystatechange = function() {
//         document.getElementById("demo").innerHTML = this.responseText;
//         document.getElementById("d1").style.background="green";

//     };
//     xhttp.open("GET", "/go");
//     xhttp.send();
//   }
//   function loadPost(){
//     xhttp.onreadystatechange = function() {
//         document.getElementById("demo").innerHTML = "POST";
//         document.getElementById("d2").style.background="orange";
//       };
//       xhttp.open("POST", "/go");
//       xhttp.send();
//   }
  
//   function loadPut() {
//     xhttp.onreadystatechange = function() {
//         document.getElementById("demo").innerHTML = "PUT";
//         document.getElementById("d3").style.background="yellow";
//     };
//     xhttp.open("PUT", "/go");
//     xhttp.send();
//   }
//   function loadDel() {
//     xhttp.onreadystatechange = function() {
//         document.getElementById("demo").innerHTML = "DELETE";
//         document.getElementById("d4").style.background="red";
//     };
//     xhttp.open("DELETE", "/go");
//     xhttp.send();
//   }
//   function loadHead() {
//     xhttp.onreadystatechange = function() {
//         document.getElementById("demo").innerHTML = "HEAD";
//         document.getElementById("d6").style.background="pink";
//     };
//     xhttp.open("HEAD", "/go");
//     xhttp.send();
//   }