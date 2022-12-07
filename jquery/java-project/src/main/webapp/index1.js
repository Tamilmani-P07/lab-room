const uri="http://localhost:9090/person";
let persons=[];
let updateIntex=0;


function getItems() {
    $.ajax({
        url:"http://localhost:9090/person",
        type:"GET",
        dataType:"json",
        success: function (data) {
            console.log(data);
            displayItem(data);
        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
    
}
function displayItem(data) {
    const tBody=document.getElementById("persons");

    const button = document.createElement("button");

    data.forEach(ele => {

        let editBtn=button.cloneNode(false);
        editBtn.innerText ="Edit";
        editBtn.setAttribute("onclick",`(editItem(${ele.id}))`);

        let delBtn=button.cloneNode(false);
        delBtn.innerText ="Delete";
        delBtn.setAttribute("onclick",`(deleteItem(${ele.id}))`);

        let tr =tBody.insertRow();

        let td1=tr.insertCell(0);
        let p_id=document.createTextNode(ele.id);
        td1.appendChild(p_id);

        let td2=tr.insertCell(1);
        let p_name=document.createTextNode(ele.name);
        td2.appendChild(p_name);

        let td3 = tr.insertCell(2);
        td3.appendChild(editBtn);
    
        let td4 = tr.insertCell(3);
        td4.appendChild(delBtn);
        
    });
}

function editItem(id){
    document.getElementById("myB").innerHTML="update";
    const item=persons.find((item) => item.id===id);
    document.getElementById("p_name").value=item.name;
    updateIntex=id;

}
function saveOrupdate(){
    //addItem();
    if (document.getElementById("myB").innerHTML == "save") {
        addItem();
    }
    else{
        updateItem();
    }
}
function addItem(){
    const addNameTextbox =document.getElementById("p_name");

    const item = { name: document.getElementById("p_name").value };
    console.log(item);
    $.ajax({
        type:"POST",
        url:"http://localhost:9090/person",
        data:JSON.stringify(item),
        success: function(result){
            getItems();
        },
        error: function(result){
            alert("msg");
        }
    });
}
function updateItem(){
    const item={
        id:updateIntex,
        name:document.getElementById("p_name").value.trim(),
    };
    $.ajax({
        type:"PUT",
        url:"http://localhost:9090/person",
        data:JSON.stringify(item),
        success: function (result){
            getItems();
            document.getElementById("myB").innerHTML="save";
            document.getElementById("p_name").value="";
            updateIntex=0;
        },
        error: function(result){
            alert("msg");
        },
    });
}
function deleteItem(id) {
    const item = {
      id: id,
      name: document.getElementById("p_name").value.trim(),
    };
    $.ajax({
      type: "DELETE",
      url: "http://localhost:9090/person",
      data: JSON.stringify(item),
      contentType:"application/json",
      success: function (result) {
        getItems();
      },
      error: function (result) {
        alert("msg");
      },
    });
  }