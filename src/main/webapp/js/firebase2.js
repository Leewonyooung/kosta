// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/11.6.0/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/11.6.0/firebase-analytics.js";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
apiKey: "AIzaSyCEl_LdUspOBg86j-ittMtgu3GIm1ZIvf0",
authDomain: "memos-c1d7e.firebaseapp.com",
projectId: "memos-c1d7e",
storageBucket: "memos-c1d7e.firebasestorage.app",
messagingSenderId: "445887604908",
appId: "1:445887604908:web:405e67fbc67b0f22fc1709",
measurementId: "G-DEDXJQJXKG"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

