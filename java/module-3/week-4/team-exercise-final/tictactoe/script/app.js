// Add code here
//TODO 1: assign name and className properties for players 1 and 2 - Objects can be helpful  
const player1 = {name: 'Yoda', className: 'p1'};
const player2 = {name: 'Darth Vader', className: 'p2'};


//TODO 2: assign values for remaining scoring sets  
//Scoring Sets  - Arrays are a handy tool in JavaScript
const row1 = [1,2,3];
const row2 = [4,5,6];
const row3 = [7,8,9];
const col1 = [1,4,7];
const col2 = [2,5,8];
const col3 = [3,6,9];
const dia1 = [1,5,9];
const dia2 = [3,5,7];

//TODO 3: Capture all of the scoringSets - An Array is a handy tool in JavaScript
const scoringSets = [row1, row2, row3, col1, col2, col3, dia1, dia2]; 

let currentPlayer = player1;  // pick a default player to start with.
let gameOver = false; // update this value based on a new game starting

//'DOMContentCheck
document.addEventListener('DOMContentLoaded', attachListeners);  //calling a named function instead of using anonymous function.



//TODO 4: Create attachListeners() function 
    //1. add event listener to game-board  ; click ; event.target -- pass to circleClick function.
    //2. add event listener to btnClearBoard; click.
function attachListeners(){

    const gameBoard = document.getElementById("game-board");
    gameBoard.addEventListener('click', (event) => { 
        circleClick(event.target); 
    });
    //Or can add directly per the following line of code; without using a variable
    //document.getElementById("game-board").addEventListener('click', (event) => { circleClick(event.target); });

    const btnClearBoard = document.getElementById('btnClearBoard');
    btnClearBoard.addEventListener('click', () => {
        clearBoard();
    });
        

}




//TODO 5: Create circleClick(selectedCircle) function 
    //an option to consider is using classList in your function per the following

    //check if circle is "available"

        //"add" player to circle

        //record score 
    
    //let user know selected circle is not valid selection
function circleClick(selectedCircle){        

    
    if( selectedCircle.classList.contains("circle")
        && !(selectedCircle.classList.contains(player1.className))
        && !(selectedCircle.classList.contains(player2.className))
        && !gameOver)
    {
        
        selectedCircle.classList.add(currentPlayer.className);
        let otherPlayer = (currentPlayer===player1) ? player2: player1;

        scoreGameBoard(currentPlayer);

        currentPlayer = otherPlayer;           
        

    }else{
        alert("Doink!");            
    }

}



 //TODO 6: Create scoreGameBoard(player) function 
      //check each scoring sets

        //check each id 

            // when player has three selected for any set, gameOver = true...... display an alert with winner. "player x Wins!"

function scoreGameBoard(player){


    scoringSets.forEach( (set) => {

        let scoreCounter = 0;

        set.forEach( (id) => {

            let scoredCircle = document.getElementById(id);

            if(scoredCircle.classList.contains(player.className)){
                scoreCounter++;
            }

        });

        //Check for win; three in a row means winning set, scoreCounter will equal 3
        if(scoreCounter === 3){
            
            gameOver = true;               
            alert(player.name.toUpperCase() + " WINS!");

        }
    });
}
   

//TODO 7: Create clearBoard() function
function clearBoard(){
    scoringSets.forEach( (set) => {

        set.forEach( (id) => {
            let circle = document.getElementById(id);
            circle.classList.remove(player1.className, player2.className);

        });


    });
    gameOver = false;
}

