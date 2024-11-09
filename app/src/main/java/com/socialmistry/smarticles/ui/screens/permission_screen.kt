package com.socialmistry.smarticles.ui.screens

import android.Manifest
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CameraPermissionScreen() {
    // don't forget to add the permission in the manifest file
    // <uses-permission android:name="android.permission.CAMERA" />
    val context = LocalContext.current
    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Toast.makeText(context, "Camera access granted!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "No camera access for you!", Toast.LENGTH_SHORT).show()
        }
    }

    PermissionRationale(
        permission = "camera",
        explanation = "Snap photos directly in the app. We promise not to take selfies on your behalf.",
        onGrant = { cameraPermissionLauncher.launch(Manifest.permission.CAMERA) },
        onDeny = {
            Toast.makeText(
                context,
                "No worries! We respect your choice.",
                Toast.LENGTH_SHORT
            ).show()
        }
    )
}

@Composable
fun NotificationPermissionScreen() {
    // don't forget to add the permission in the manifest file
    // <uses-permission android:name="android.permission.ACCESS_NOTIFICATION_POLICY" />
    val context = LocalContext.current
    val notificationPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Toast.makeText(context, "Notification access granted!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "No notification access for you!", Toast.LENGTH_SHORT).show()
        }
    }

    PermissionRationale(
        permission = "notifications",
        explanation = "We’ll only notify you when it’s truly awesome. Pinky promise!",
        onGrant = { notificationPermissionLauncher.launch(Manifest.permission.ACCESS_NOTIFICATION_POLICY) },
        onDeny = {
            Toast.makeText(
                context,
                "No worries! We respect your choice.",
                Toast.LENGTH_SHORT
            ).show()
        }
    )
}

@Composable
fun CallPermissionScreen() {
    val context = LocalContext.current
    val callPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Toast.makeText(context, "Call access granted!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "No call access for you!", Toast.LENGTH_SHORT).show()
        }
    }

    PermissionRationale(
        permission = "call",
        explanation = "We need to make calls to connect you with your friends and family.",
        onGrant = { callPermissionLauncher.launch(Manifest.permission.CALL_PHONE) },
        onDeny = {
            Toast.makeText(
                context,
                "No worries! We respect your choice.",
                Toast.LENGTH_SHORT
            ).show()
        }
    )
}


@Composable
fun PermissionRationale(
    permission: String,
    explanation: String,
    onGrant: () -> Unit,
    onDeny: () -> Unit,
    modifier: Modifier = Modifier, // this allow adding modifiers to the composable
    icon: ImageVector = Icons.Default.Warning,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Alert",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.size(32.dp))
            Text(
                text = "Hey there! 👋 We need your $permission",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = explanation,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = onGrant) {
                    Text("Sure, go ahead")
                }
                Button(onClick = onDeny) {
                    Text("Nope, maybe later")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PermissionRationalePreview() {
    PermissionRationale(
        icon = Icons.Default.LocationOn,
        permission = "location ️",
        explanation = "We need your location to show you the weather",
        onGrant = {},
        onDeny = {}
    )
}


@Preview(showBackground = true)
@Composable
private fun NotificationPermissionPreview() {
    PermissionRationale(
        icon = Icons.Default.Notifications,
        permission = "notifications 🔔",
        explanation = " We’ll only notify you when it’s truly awesome. Pinky promise!",
        onGrant = { /* Handle grant gracefully */ },
        onDeny = { /* Handle denial gracefully */ }
    )
}

@Preview(showBackground = true)
@Composable
private fun CameraPermissionPreview() {
    PermissionRationale(
        icon = Icons.Default.Info,
        permission = "camera 📸",
        explanation = "Snap photos directly in the app. We promise not to take selfies on your behalf.",
        onGrant = { /* Request camera permission */ },
        onDeny = { /* Handle denial gracefully */ }
    )
}


@Preview(showBackground = true)
@Composable
private fun CallPermissionPreview() {
    PermissionRationale(
        icon = Icons.Default.Phone,
        permission = "Make Calls",
        explanation = "We need to make calls to connect you with your friends and family.",
        onGrant = { /* Request microphone permission */ },
        onDeny = { /* Handle denial gracefully */ }
    )
}




