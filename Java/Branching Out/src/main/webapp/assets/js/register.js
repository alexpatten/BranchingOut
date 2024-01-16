function performRegister() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var email = document.getElementById("email").value;
        var errorMsgLabel = document.getElementById("errorMsgLabel");
        
        // Reset the error label content
    	errorMsgLabel.textContent = '';

        fetch('../Register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: 'username=' + encodeURIComponent(username) + '&password=' + encodeURIComponent(password) + '&email=' + encodeURIComponent(email),
        })
        .then(response => response.text())
        .then(data => {
            console.log(data);
            
            // Check if login was successful (modify this condition based on your logic)
            if (data.includes('Registration successful')) {
                // Redirect to main.html
                window.parent.location.href = 'registerredirect.html';
            }
            else {
				if (data.includes('Username already exists')) {
                	errorMsgLabel.textContent = 'Username already exists.';
	            }
	            else if (data.includes('Email already exists')) {
	                errorMsgLabel.textContent = 'Email already exists.';
	            }
	            else {
					// You can write out the actual data received in the response for debugging purposes
			        console.log('Unexpected response data:', data);
			
			        // Optionally, you can set a generic error message
			        errorMsgLabel.textContent = 'Unexpected error during registration.';
				}
	
	            errorMsgLabel.classList.remove('hidden');
			}
        })
        .catch(error => console.error('Error:', error));
}