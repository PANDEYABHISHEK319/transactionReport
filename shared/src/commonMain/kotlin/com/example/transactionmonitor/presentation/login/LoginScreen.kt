package com.example.transactionmonitor.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.transactionmonitor.domain.repository.AuthRepository
import com.example.transactionmonitor.data.repository.FakeAuthRepository
import com.example.transactionmonitor.presentation.components.PrimaryButton

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    authRepository: AuthRepository = FakeAuthRepository()
) {
    val viewModel = remember { LoginViewModel(authRepository) }
    val uiState by viewModel.uiState.collectAsState()

    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var rememberMeInput by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome Back",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Login to access your transactions",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = emailInput,
                onValueChange = { emailInput = it; viewModel.emailOrMobile = it },
                label = { Text("Email / Mobile Number") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = passwordInput,
                onValueChange = { passwordInput = it; viewModel.password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = rememberMeInput,
                        onCheckedChange = { rememberMeInput = it; viewModel.rememberMe = it }
                    )
                    Text("Remember Me", style = MaterialTheme.typography.bodySmall)
                }
                TextButton(onClick = { /* Forgot password action */ }) {
                    Text("Forgot Password?", style = MaterialTheme.typography.bodySmall)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (uiState is LoginUiState.Error) {
                Text(
                    text = (uiState as LoginUiState.Error).message,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            PrimaryButton(
                text = if (uiState is LoginUiState.Loading) "Logging in..." else "Login",
                onClick = { viewModel.login(onLoginSuccess) },
                enabled = uiState !is LoginUiState.Loading
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = { /* Google sign in */ },
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("Continue with Google")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(horizontalArrangement = Arrangement.Center) {
                Text("Don't have an account? ", style = MaterialTheme.typography.bodySmall)
                TextButton(onClick = { /* Sign up action */ }, contentPadding = PaddingValues(0.dp)) {
                    Text("Sign Up", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
