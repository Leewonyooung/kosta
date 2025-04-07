importScripts("https://www.gstatic.com/firebasejs/11.6.0/firebase-app-compat.js");
// eslint-disable-next-line no-undef
importScripts("https://www.gstatic.com/firebasejs/11.6.0/firebase-messaging-compat.js");

const firebaseConfig = {
    apiKey: "AIzaSyCEl_LdUspOBg86j-ittMtgu3GIm1ZIvf0",
    authDomain: "memos-c1d7e.firebaseapp.com",
    projectId: "memos-c1d7e",
    storageBucket: "memos-c1d7e.firebasestorage.app",
    messagingSenderId: "445887604908",
    appId: "1:445887604908:web:405e67fbc67b0f22fc1709",
    measurementId: "G-DEDXJQJXKG"
};
if (!firebase.apps.length) {
    firebase.initializeApp(firebaseConfig);
}
const messaging = firebase.messaging();

messaging.onBackgroundMessage(function (payload) {
    console.log("Received background message ", payload);

    const notificationTitle = payload.notification.title;
    const notificationOptions = {
        body: payload.notification.body,
    };

    // eslint-disable-next-line no-restricted-globals
    self.registration.showNotification(
        notificationTitle,
        notificationOptions
    );
});