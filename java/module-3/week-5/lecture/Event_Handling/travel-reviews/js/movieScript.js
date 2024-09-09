const apiUrl = 'https://teapi.netlify.app/movies-api/movies'; // API URL
const baseUrl = 'https://teapi.netlify.app';



//hard coded option
function fetchMovies() {
    console.log(movies);
    displayMovies(movies);
        
}

// async await - Asynchronous communication option
// async function fetchMovies() {
//     try {
//         const response = await fetch(apiUrl);
//         if (!response.ok) {
//             throw new Error(`HTTP error! status: ${response.status}`);
//         }
//         const data = await response.json();
//         displayMovies(data);
//     }catch (error) {
//         console.error('Error fetching movies:', error);
//     }
// }

// Promise - Asynchronous communication option - (BOS taught method)
// function fetchMovies() {
//     fetch(apiUrl)
//         .then(response => response.json())
//         .then(data => {
//             displayMovies(data);
//         })
//         .catch(error => {
//             console.error('Error fetching movies:', error);
//         });
// }

function displayMovies(movies) {
    const moviesContainer = document.getElementById('movies-container');
    movies.forEach(movie => {
        const movieCard = document.createElement('div');
        movieCard.classList.add('movie-card', 'clearfix');
        

        const moviePoster = document.createElement('img');
        moviePoster.src = baseUrl + movie.posterImage;
        moviePoster.alt = movie.title;

        const movieInfo = document.createElement('div');
        movieInfo.classList.add('movie-info');

        const movieTitle = document.createElement('h2');
        movieTitle.textContent = movie.title;

        const releaseDate = document.createElement('p');
        releaseDate.textContent = `Release Date: ${movie.releaseDate}`;

        const movieGenres = document.createElement('p');
        movieGenres.textContent = `Genres: ${movie.genres.map(genre => genre.name).join(', ')}`;
        movieGenres.classList.add('genre');

        const movieDirectors = document.createElement('p');
        movieDirectors.textContent = `Director(s): ${movie.directors.map(director => director.name).join(', ')}`;
        movieDirectors.classList.add('director');

        const movieSummary = document.createElement('p');
        movieSummary.textContent = movie.summary;
        movieSummary.classList.add('summary');

        movieInfo.appendChild(movieTitle);
        movieInfo.appendChild(releaseDate);
        movieInfo.appendChild(movieGenres);
        movieInfo.appendChild(movieDirectors);
        movieInfo.appendChild(movieSummary);

        movieCard.appendChild(moviePoster);
        movieCard.appendChild(movieInfo);
        moviesContainer.appendChild(movieCard);
    });
}
document.addEventListener("DOMContentLoaded", function() {
// Fetch and display movies on page load
    fetchMovies();
});
