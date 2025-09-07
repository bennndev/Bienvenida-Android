package com.example.bienvenida_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenida_android.ui.theme.BienvenidaAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BienvenidaAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = LightGreen
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

// Color: Fondo de la app
val LightGreen = Color(0xFFD2E7D7)

// Componente: Aplicación de tarjeta de negocio
@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Sección superior: Imagen y texto
        ImageNameAndTitle()

        // Espacio para separar las secciones
        Spacer(modifier = Modifier.height(250.dp))

        // Sección inferior: Información de contacto
        ContactInfo()
    }
}

// Sección superior: Imagen y texto
@Composable
fun ImageNameAndTitle(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(100.dp) // El tamaño del Box será el mismo que el de la imagen
                .background(color = Color(0xFF002137)) // Aplica el color de fondo
                .padding(bottom = 8.dp), // El padding se aplica al Box
            contentAlignment = Alignment.Center // Centra la imagen dentro del Box
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null, // La imagen es decorativa
                modifier = Modifier.fillMaxSize() // La imagen llenará el Box
            )
        }
        // Nombre de la persona
        Text(
            text = "Benjamín Sullca",
            fontSize = 32.sp,
            color = Color.Black
        )

        // Título o cargo
        Text(
            text = "Estudiante de Tecsup",
            fontSize = 16.sp,
            color = Color(0xFF1E6F3D)
        )
    }
}

// Cuerpo: Contenedor de información de contacto
@Composable
fun ContactInfo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(start = 64.dp, end = 64.dp)
    ) {
        // Información de teléfono
        ContactRow(
            icon = Icons.Default.Phone,
            contentDescription = "Número de teléfono",
            text = "+51 974 666 807"
        )
        // Espaciador entre elementos de contacto
        Spacer(modifier = Modifier.height(16.dp))

        // Información de redes sociales
        ContactRow(
            icon = Icons.Default.Share,
            contentDescription = "Nombre de usuario de redes sociales",
            text = "@bennn.h1"
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Información de correo electrónico
        ContactRow(
            icon = Icons.Default.Email,
            contentDescription = "Correo electrónico",
            text = "benjamin.sullca1103@gmail.com"
        )
    }
}

// Componente: Información de contacto
@Composable
fun ContactRow(
    icon: ImageVector,
    contentDescription: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color(0xFF1E6F3D), // Color del icono
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}