
import { initializeApp } from "https://www.gstatic.com/firebasejs/11.6.0/firebase-app.js";
import { getMessaging, getToken, onMessage } from "https://www.gstatic.com/firebasejs/11.6.0/firebase-messaging.js";

// firebase.js 상단에 추가
navigator.serviceWorker.register("/fcm/firebase-messaging-sw.js")
    .then(() => navigator.serviceWorker.ready)
    .then((registration) => {
        console.log("✅ ServiceWorker 활성화 완료:", registration);

        const messaging = getMessaging();

        getToken(messaging, {
            vapidKey: 'BNSpslyrfnObW4PjHk0asUhUwfC_MYGSrxw0W2cU1F1kHIUy6Hxi9anh_DJ6-Lm5Bx8o0Ld16MoyQh7SrAi_GKc',
            serviceWorkerRegistration: registration
        }).then((currentToken) => {
            if (currentToken) {
                console.log("📬 Token 발급 성공:", currentToken);
            } else {
                console.warn("⚠️ Token 발급 실패: 브라우저 권한 또는 설정 확인 필요");
            }
        }).catch((error) => {
            console.error("❌ Token 발급 중 오류 발생:", error);
        });

        onMessage(messaging, (payload) => {
            console.log("📥 포그라운드 메시지 수신:", payload);
        });

    }).catch((error) => {
    console.error("❌ ServiceWorker 등록 또는 준비 실패:", error);
});
const firebaseConfig = {
    apiKey: "AIzaSyCEl_LdUspOBg86j-ittMtgu3GIm1ZIvf0",
    authDomain: "memos-c1d7e.firebaseapp.com",
    projectId: "memos-c1d7e",
    storageBucket: "memos-c1d7e.firebasestorage.app",
    messagingSenderId: "445887604908",
    appId: "1:445887604908:web:405e67fbc67b0f22fc1709",
    measurementId: "G-DEDXJQJXKG"
};

initializeApp(firebaseConfig);

const messaging = getMessaging();
console.log(messaging);

export const requestForToken = () => {
    return getToken(messaging, {
        vapidKey: 'BNSpslyrfnObW4PjHk0asUhUwfC_MYGSrxw0W2cU1F1kHIUy6Hxi9anh_DJ6-Lm5Bx8o0Ld16MoyQh7SrAi_GKc'
    }).then((currentToken) => {
        if (currentToken) {
            console.log("Token:", currentToken); // ✅ 여기서 토큰이 출력되면 성공!
        } else {
            console.log("No registration token available.");
        }
    }).catch((error) => {
        console.error("An error occurred while retrieving token. ", error);
    })
.catch((error) => {
        console.log(error);
    })
}

export const onMessageListener = () => {
    return new Promise((resolve) => {
        onMessage(messaging, (payload) => {
            resolve(payload);
        })
    })
}

requestForToken();