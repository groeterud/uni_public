//loads the content on the webpage
document.addEventListener('DOMContentLoaded', function(){ 
    const list = document.querySelector('#movie-list ul');
    const forms = document.forms; 

    //delete list itewm when clicked
    list.addEventListener('click', (e) => {
      if(e.target.className == 'delete'){
        const li = e.target.parentElement;
        li.parentNode.removeChild(li);
      }
    });  

    //the add button event handler to add list items 
    const addForm = forms['add-movie'];
    addForm.addEventListener('submit', function(e){
      e.preventDefault();  

      // create elements
      const value = addForm.querySelector('input[type="text"]').value; //obtain the new input 
      const li = document.createElement('li'); //element creation
      const movieName = document.createElement('span');
      const deleteBtn = document.createElement('span');

      // add text content
      movieName.textContent = value;
      deleteBtn.textContent = ' - delete';  

      // add required classes for newly added movie
      movieName.classList.add('name');
      deleteBtn.classList.add('delete');  

      // append the movie name and delete button to <li> (to DOM)
      li.appendChild(movieName);
      li.appendChild(deleteBtn);
      list.appendChild(li);
    });
  })
  