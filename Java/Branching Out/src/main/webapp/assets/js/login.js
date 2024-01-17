function performLogin() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        fetch('../MyLogin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: 'username=' + encodeURIComponent(username) + '&password=' + encodeURIComponent(password),
        })
        .then(response => response.text())
        .then(data => {
            console.log(data);
            
            // Check if login was successful (modify this condition based on your logic)
            if (data.includes('User found')) {
                // Redirect to main.html
                window.parent.location.href = 'secured/main.html';
            }
        })
        .catch(error => console.error('Error:', error));
}