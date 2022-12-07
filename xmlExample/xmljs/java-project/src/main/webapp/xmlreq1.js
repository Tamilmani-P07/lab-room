const xhttp = new XMLHttpRequest();

function loadGet() {
    xhttp.onreadystatechange = function() {
        document.getElementById("demo").innerHTML = this.responseText;
        document.getElementById("d1").style.background="green";

    };
    xhttp.open("GET", "/go");
    xhttp.send();
  }
  function loadPost(){
    xhttp.onreadystatechange = function() {
        document.getElementById("demo").innerHTML = "POST";
        document.getElementById("d2").style.background="orange";
      };
      xhttp.open("POST", "/go");
      xhttp.send();
  }
  
  function loadPut() {
    xhttp.onreadystatechange = function() {
        document.getElementById("demo").innerHTML = "PUT";
        document.getElementById("d3").style.background="yellow";
    };
    xhttp.open("PUT", "/go");
    xhttp.send();
  }
  function loadDel() {
    xhttp.onreadystatechange = function() {
        document.getElementById("demo").innerHTML = "DELETE";
        document.getElementById("d4").style.background="red";
    };
    xhttp.open("DELETE", "/go");
    xhttp.send();
  }
  function loadHead() {
    xhttp.onreadystatechange = function() {
        document.getElementById("demo").innerHTML = "HEAD";
        document.getElementById("d6").style.background="pink";
    };
    xhttp.open("HEAD", "/go");
    xhttp.send();
  }