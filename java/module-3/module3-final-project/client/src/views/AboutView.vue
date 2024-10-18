<template>
    <div>
      <header>
        <h1>Music Practice Tracker!</h1>
        <img src="img/Generic-Music-Notes.jpg" alt="Generic Music Picture" class="music-image" />
        <nav>
          <ul>
            <li><router-link to="/practice-session">Practice Sessions</router-link></li>
            <li><router-link to="/goal">Goals</router-link></li>
            <li><router-link to="/about">About</router-link></li>
            <li><router-link to="/contact">Contact</router-link></li>
          </ul>
        </nav>
      </header>
  
      <section>
        <h2>About</h2>
          <p>This app was created to help musicians track their practice sessions by Dr. David Humphreys</p>
          <p>Prior to Oklahoma State University, Dr. Humphreys taught at Western Kentucky University, Texas Woman’s University, Texas Wesleyan University, and the University of North Texas. He previously held teaching positions at McKinney ISD (McKinney, TX), Edmond Memorial High School (Edmond, OK), Putnam City High School (Oklahoma City, OK), and El Sistema Oklahoma. Dr. Humphreys has won multiple regional Tuba Euphonium Conference solo competitions on both tuba and euphonium. He has been invited to perform at several competitions and festivals including the Leonard Falcone International Euphonium and Tuba Festival; the Eastman Tuba Academy; the Buffet Crampon Tuba Euphonium Academy; various Regional Tuba Euphonium Conferences; and the International Tuba Euphonium Conference (ITEC). As a chamber musician, Dr. Humphreys is an active freelance tuba and euphonium player in Oklahoma and Texas.  He was most recently principal tuba of the Owensboro (KY) Symphony. He has been a member of the Western Kentucky University Faculty Brass Quintet, the Texas Wesleyan University Brass Quintet, and the Boulevard Brass Quintet, and was previously principal E-flat tuba for the Dallas Brass Band. He is a founding member of the Juggernaut Tuba Euphonium Quartet, and the Frontier Brass Band (OK). He has performed with the faculty brass quintets at the University of North Texas, Oklahoma City University, and the University of Oklahoma. Additionally, he has performed with the Louisville Orchestra, Orchestra Kentucky (Bowling Green), the Oklahoma City Philharmonic, the Tulsa Symphony Orchestra, and the Symphony of Northwest Arkansas. Dr. Humphreys has degrees in instrumental music education (BME, University of Oklahoma) and music performance (MM euphonium, University of Oklahoma; MM tuba, Oklahoma City University; DMA tuba, University of North Texas). His primary teachers include Don Little, Matt Good, Dr. David Childs, Dr. Ryan Robinson, Dr. Jeff Baker, and Brian Dobbins. His professional affiliations include the International Tuba Euphonium Association, Texas Music Educators Association, and Oklahoma Music Educators Association. Dr. Humphreys is an Eastman Winds Artist.</p>
          <p>To learn more, click <a href="https://experts.okstate.edu/david.humphreys" target="_blank">here!</a></p>
      </section>
  
      <footer>
        <p>&copy; 2024 Humphreys Music Practice Tracker. All Rights Reserved.</p>
      </footer>
    </div>
  </template>
  
  <script>
  export default {
    name: "AboutView"
  };
  </script>
  
  <style scoped>
  #about {
    text-align: center;
    margin-top: 50px;
  }

  a:hover {
    text-decoration: underline;
  }
  </style>
  