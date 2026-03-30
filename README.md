# Serenity BDD Screenplay Pattern - OpenCart Demo

[![Serenity BDD](https://img.shields.io/badge/Serenity-BDD-blue.svg)](http://www.serenity-bdd.info/)
[![Screenplay Pattern](https://img.shields.io/badge/Pattern-Screenplay-green.svg)](https://serenity-bdd.github.io/docs/screenplay/)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.java.com/)
[![Gradle](https://img.shields.io/badge/Gradle-9.2.1-blue.svg)](https://gradle.org/)

> Proyecto de automatización de pruebas E2E usando Serenity BDD con el patrón Screenplay para OpenCart.

## 📊 Reporte de Pruebas

🚀 **[Ver Reporte en GitHub Pages](https://ejcondorf88.github.io/serenity-bdd-screnn-play/)**

---

## 🎯 Características

- ✅ **Patrón Screenplay**: Arquitectura robusta y mantenible
- ✅ **Serenity BDD**: Reportes detallados y documentación viva
- ✅ **OpenCart Demo**: Pruebas contra [opencart.abstracta.us](http://opencart.abstracta.us/)
- ✅ **E2E Completo**: Flujo de compra como invitado
- ✅ **GitHub Actions**: Integración continua lista
- ✅ **GitHub Pages**: Reportes automatizados

---

## 🛠️ Requisitos Previos

| Requisito | Versión | Descarga |
|-----------|---------|----------|
| Java JDK | 17+ | [Oracle](https://www.oracle.com/java/technologies/downloads/) |
| Gradle | 9.2.1+ | [Gradle](https://gradle.org/install/) |
| Chrome | Última versión | [Chrome](https://www.google.com/chrome/) |
| ChromeDriver | Automático | Se descarga automáticamente |

---

## 🚀 Ejecutar el Proyecto

### Opción 1: Usando Gradle Wrapper (Recomendado)

```bash
# Ejecutar todas las pruebas
./gradlew clean test

# Ejecutar prueba específica
./gradlew clean test --tests "*CompraInvitado*"

# Ejecutar por tags
./gradlew clean test -Dcucumber.options="--tags @e2e"
```

### Opción 2: Usando Gradle Instalado

```bash
gradle clean test
```

### Opción 3: En Windows (cmd/PowerShell)

```cmd
gradlew clean test
```

---

## 📁 Estructura del Proyecto

```
screen-play/
├── src/test/java/screenplay/
│   ├── runner/              # Cucumber Test Runner
│   ├── stepdefinitions/     # Glue code (Step Definitions)
│   ├── tasks/               # Acciones del usuario (Screenplay)
│   ├── questions/           # Verificaciones (Screenplay)
│   ├── interactions/        # Interacciones personalizadas
│   ├── model/               # DTOs y objetos de dominio
│   └── ui/                  # Selectores de UI
├── src/test/resources/
│   ├── features/            # Archivos .feature (Gherkin)
│   └── serenity.conf        # Configuración Serenity
├── docs/                    # Reporte para GitHub Pages
├── build.gradle             # Dependencias Gradle
└── README.md                # Este archivo
```

---

## 🎭 Patrón Screenplay

### ¿Qué es?

El **Patrón Screenplay** es una forma de escribir pruebas de aceptación legibles y mantenibles, inspirada en el teatro:

| Concepto | Descripción | Ejemplo |
|----------|-------------|---------|
| **Actor** | Quien ejecuta la acción | `Actor guestUser` |
| **Task** | Lo que HACE el actor | `AddProduct.toCart(Product.iPhone())` |
| **Question** | Lo que VERIFICA el actor | `OrderConfirmationMessage.displayed()` |
| **UI** | Dónde está el elemento | `OpenCartPage.ADD_TO_CART_BUTTON` |

### Ejemplo de Flujo

```java
// Agregar producto al carrito
actor.attemptsTo(
    AddProduct.toCart(Product.iPhone())
);

// Verificar mensaje
actor.should(
    seeThat(OrderConfirmationMessage.displayed(), 
    equalTo("Your order has been placed!"))
);
```

---

## 📝 Escenarios de Prueba

### Feature: Compra como Invitado

```gherkin
Escenario: Realizar una compra exitosa como invitado
  Dado que el usuario esta en la pagina principal de la tienda
  Cuando agrega el producto "iPhone" al carrito
  Y agrega el producto "MacBook" al carrito
  Y navega al carrito de compras
  Entonces deberia visualizar los productos en el carrito
  Cuando procede al checkout
  Y selecciona la opcion Guest Checkout
  Y completa el formulario de informacion personal
  Y selecciona el metodo de envio
  Y acepta los terminos y condiciones
  Y confirma la orden
  Entonces deberia visualizar el mensaje de confirmacion Your order has been placed!
```

---

## 📊 Reportes

### Reporte Local

Después de ejecutar las pruebas:

```
build/reports/tests/test/index.html
```

Abrir en navegador:
```bash
# Windows
start build/reports/tests/test/index.html

# Mac
open build/reports/tests/test/index.html

# Linux
xdg-open build/reports/tests/test/index.html
```

### Reporte en GitHub Pages

1. Ve a **Settings → Pages** en tu repositorio
2. Selecciona **Source**: Deploy from a branch
3. Selecciona **Branch**: main
4. Selecciona **Folder**: /docs
5. Guarda y espera unos minutos

🔗 URL: `https://ejcondorf88.github.io/serenity-bdd-screnn-play/`

---

## 🔧 Configuración

### serenity.conf

```hocon
webdriver {
  driver = chrome
  base.url = "http://opencart.abstracta.us/"
}

chrome {
  switches = """--start-maximized;--test-type;--no-sandbox;
  --ignore-certificate-errors;--disable-popup-blocking"""
}
```

### Tags Disponibles

| Tag | Descripción |
|-----|-------------|
| `@e2e` | Pruebas End-to-End |
| `@compra` | Flujo de compra |
| `@critical` | Casos críticos |
| `@smoke` | Smoke tests |
| `@happy-path` | Flujo feliz |

---

## 🤝 Contribuir

1. Fork el repositorio
2. Crea una rama (`git checkout -b feature/nueva-funcionalidad`)
3. Commit cambios (`git commit -am 'feat: agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

---

## 📚 Recursos

- [Serenity BDD Documentation](https://serenity-bdd.github.io/)
- [Screenplay Pattern](https://serenity-bdd.github.io/docs/screenplay/)
- [Cucumber Documentation](https://cucumber.io/docs/)
- [OpenCart Demo](http://opencart.abstracta.us/)

---

## 👨‍💻 Autor

**ejcondorf88**

---

## 📝 Licencia

Este proyecto está bajo la Licencia MIT.

---

<div align="center">

⭐ **¡Dale una estrella si te fue útil!** ⭐

</div>
