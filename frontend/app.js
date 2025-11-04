// ==== CONFIGURACIÓN EDITABLE ====
// Cambiá BASE si tu backend corre en otra URL
let BASE = localStorage.getItem('apiBase') || 'http://localhost:8080';

// Si tu backend usa otros paths, ajustá acá:
const EP = {
  listScrims: () => `${BASE}/api/scrims`,
  createScrim: () => `${BASE}/api/scrims`,
  getScrim: (id) => `${BASE}/api/scrims/${id}`,

  // acciones (ajustá a tus endpoints reales)
  addPlayer: (id) => `${BASE}/api/scrims/${id}/jugadores`,          // POST {nombre}
  confirm:  (id) => `${BASE}/api/scrims/${id}/confirmaciones`,      // POST
  start:    (id) => `${BASE}/api/scrims/${id}/iniciar`,              // POST
  finish:   (id) => `${BASE}/api/scrims/${id}/finalizar`,            // POST
  cancel:   (id) => `${BASE}/api/scrims/${id}/cancelar`              // POST
};

// ==== UTILIDADES ====
const $ = (sel) => document.querySelector(sel);
const log = (m) => { const p = $('#log'); p.textContent += `\n${new Date().toLocaleTimeString()} • ${m}`; p.scrollTop = p.scrollHeight; };

const jsonFetch = async (url, opts = {}) => {
  const res = await fetch(url, { headers: {'Content-Type': 'application/json'}, ...opts });
  const txt = await res.text();
  let data = null; try { data = txt ? JSON.parse(txt) : null; } catch { /* no-op */ }
  if(!res.ok){ throw new Error(`HTTP ${res.status}: ${txt}`); }
  return data;
};

// ==== RENDER ====
const renderScrims = (items=[]) => {
  const box = $('#scrimsList');
  box.innerHTML = items.map(s => `
    <div class="card">
      <h3>ID: ${s.id ?? '(sin id)'}</h3>
      <div><b>Juego:</b> ${s.juego}</div>
      <div><b>Formato:</b> ${s.formato}</div>
      <div><b>Región:</b> ${s.region}</div>
      <div><b>Rango:</b> ${s.rangoMin} - ${s.rangoMax}</div>
      <div><b>Lat Máx:</b> ${s.latenciaMax}</div>
      <div><b>Estado:</b> ${s.estado ?? '(ver backend)'}</div>
    </div>
  `).join('');
};

// ==== ACCIONES ====
const crearScrim = async () => {
  try {
    const body = {
      juego: $('#juego').value,
      formato: $('#formato').value,
      rangoMin: parseFloat($('#rangoMin').value),
      rangoMax: parseFloat($('#rangoMax').value),
      region: $('#region').value,
      latenciaMax: parseFloat($('#latenciaMax').value)
    };
    const data = await jsonFetch(EP.createScrim(), { method: 'POST', body: JSON.stringify(body) });
    log(`Scrim creado: ${JSON.stringify(data)}`);
    $('#scrimId').value = data?.id || '';
    $('#accionScrimId').value = data?.id || '';
  } catch (e) { log(`Error crearScrim → ${e.message}`); }
};

const listar = async () => {
  try {
    const data = await jsonFetch(EP.listScrims());
    renderScrims(Array.isArray(data) ? data : (data?.content || []));
    log('Scrims listados');
  } catch (e) { log(`Error listar → ${e.message}`); }
};

const ver = async () => {
  const id = $('#scrimId').value.trim();
  if(!id) return log('Ingresá un ID para ver');
  try {
    const data = await jsonFetch(EP.getScrim(id));
    renderScrims([data]);
    log(`Scrim ${id} obtenido`);
  } catch (e) { log(`Error ver → ${e.message}`); }
};

const accion = async (tipo) => {
  const id = $('#accionScrimId').value.trim();
  if(!id) return log('Ingresá un ID de scrim');
  let url = EP[tipo](id);
  let opts = { method: 'POST' };
  if(tipo === 'addPlayer'){
    const nombre = $('#jugadorNombre').value.trim() || 'Jugador Demo';
    opts.body = JSON.stringify({ nombre });
  }
  try {
    const data = await jsonFetch(url, opts);
    log(`${tipo} OK → ${JSON.stringify(data)}`);
  } catch(e){ log(`Error ${tipo} → ${e.message}`); }
};

// ==== WIRE ====
window.addEventListener('DOMContentLoaded', () => {
  // config base
  $('#apiBase').value = BASE;
  $('#saveConfig').onclick = () => { BASE = $('#apiBase').value.trim(); localStorage.setItem('apiBase', BASE); log(`API Base guardada: ${BASE}`); };

  $('#btnCrear').onclick = crearScrim;
  $('#btnListar').onclick = listar;
  $('#btnGet').onclick = ver;

  $('#btnAddPlayer').onclick = () => accion('addPlayer');
  $('#btnConfirm').onclick   = () => accion('confirm');
  $('#btnStart').onclick     = () => accion('start');
  $('#btnFinish').onclick    = () => accion('finish');
  $('#btnCancel').onclick    = () => accion('cancel');

  listar();
});
