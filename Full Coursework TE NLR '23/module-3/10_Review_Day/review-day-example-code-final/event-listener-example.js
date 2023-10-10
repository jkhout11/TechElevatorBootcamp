    
    
    //Use named function to handle event
    
    // function changeGreeting() {
    //       let greetingHeader = document.getElementById('greeting');
    //       greetingHeader.innerText = 'Goodbye';
    //     }


    // let changeButton = document.getElementById('change-greeting');    
    // changeButton.addEventListener('click', (event) => {
    //       changeGreeting();
    //     });
        
    
   

    //Anonymous Function to handle event    
    // changeButton.addEventListener('click', (event) => {
    //       let greetingHeader = document.getElementById('greeting');
    //       greetingHeader.innerText = 'Goodbye';
    //     });
            
    

    //  function changeGreeting(event) {
    //           let greetingHeader = document.getElementById('greeting');
    //           greetingHeader.innerText = 'Goodbye - triggered by ' + event.type +  ' event';
    //         }


    // let changeButton = document.getElementById('change-greeting');    
    // changeButton.addEventListener('click', changeGreeting);

    
    function changeGreeting(chgButton) {
          let greetingHeader = document.getElementById('greeting');
          greetingHeader.innerText = 'Goodbye - triggered by ' + chgButton.id +  ' element';
        }


    let changeButton = document.getElementById('change-greeting');    
    changeButton.addEventListener('click',(event) => {
        changeGreeting(event.target);

    });



    // for of on a string
    const myString = "Hello World again!";
    for(ele of myString){
        console.log(ele);
    }


    const greetingLink = document.getElementById('greetingLink');
    greetingLink.setAttribute('href', 'http://google.com');
     
 
      