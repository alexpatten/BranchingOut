function performLogin() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    // Use AJAX to send the credentials to the server for authentication
    $.ajax({
        type: "POST",
        url: "http://localhost:your_port/your_authentication_endpoint", // Update with your server-side endpoint
        data: { username: username, password: password },
        success: function (response) {
            // Handle the authentication response
            if (response.success) {
                // After successful login, navigate to main.html
                window.parent.location.href = 'main.html';
            } else {
                // Display an error message or take appropriate actions on login failure
                alert("Login failed. Please check your credentials.");
            }
        },
        error: function () {
            // Handle errors during the AJAX request
            alert("An error occurred during the login process.");
        }
    });
}