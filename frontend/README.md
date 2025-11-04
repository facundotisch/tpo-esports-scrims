# eScrims Front Demo

Front-end mínimo en **HTML + CSS + Vanilla JS** para integrarse con el backend de scrims.

## 🚀 Uso
1. Asegurate de correr tu backend (por defecto en `http://localhost:8080`).
2. Abrí `index.html` con tu navegador.
3. Ajustá la **API Base** arriba a la derecha si usás otra URL.

## 🔧 Endpoints
Si tus rutas son diferentes, editá el objeto **EP** en `app.js`:

```js
const EP = {
  listScrims: () => `${BASE}/api/scrims`,
  createScrim: () => `${BASE}/api/scrims`,
  getScrim: (id) => `${BASE}/api/scrims/${id}`,
  addPlayer: (id) => `${BASE}/api/scrims/${id}/jugadores`,   // POST {nombre}
  confirm:  (id) => `${BASE}/api/scrims/${id}/confirmaciones`,
  start:    (id) => `${BASE}/api/scrims/${id}/iniciar`,
  finish:   (id) => `${BASE}/api/scrims/${id}/finalizar`,
  cancel:   (id) => `${BASE}/api/scrims/${id}/cancelar`,
}
```

## 🧪 Probá rápido
- **Crear scrim** completa el formulario y hace `POST /api/scrims`.
- **Listar** llama a `GET /api/scrims` (si tu backend devuelve paginado, intentará leer `content`).
- **Ver** hace `GET /api/scrims/{id}`.
- **Acciones** llaman a los endpoints de cambios de estado.
