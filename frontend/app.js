let BASE = localStorage.getItem('apiBase') || 'http://localhost:8080';
const EP = {
  listScrims: () => `${BASE}/api/scrims`,
  createScrim: () => `${BASE}/api/scrims`,
  getScrim: (id) => `${BASE}/api/scrims/${id}`,
  addPlayer: (id) => `${BASE}/api/scrims/${id}/jugadores`,
  confirm:  (id) => `${BASE}/api/scrims/${id}/confirmaciones`,
  start:    (id) => `${BASE}/api/scrims/${id}/iniciar`,
  finish:   (id) => `${BASE}/api/scrims/${id}/finalizar`,
  cancel:   (id) => `${BASE}/api/scrims/${id}/cancelar`
};
const $ = s=>document.querySelector(s);
const log = m=>{ const p=$('#log'); p.textContent += `\n${new Date().toLocaleTimeString()} • ${m}`; p.scrollTop=p.scrollHeight; };
const jsonFetch = async (url, opts={})=>{
  const res = await fetch(url,{headers:{'Content-Type':'application/json'},...opts});
  const txt = await res.text(); let data=null; try{ data = txt?JSON.parse(txt):null; }catch{}
  if(!res.ok) throw new Error(`HTTP ${res.status}: ${txt}`); return data;
};
const render = (items=[])=>{
  const box = $('#scrimsList');
  box.innerHTML = items.map(s=>`<div class="card"><h3>id: ${s.id??'-'}</h3>
  <div><b>juego:</b> ${s.juego??'-'}</div>
  <div><b>formato:</b> ${s.formato??'-'}</div>
  <div><b>región:</b> ${s.region??'-'}</div>
  <div><b>rango:</b> ${s.rangoMin??'-'} - ${s.rangoMax??'-'}</div>
  <div><b>lat máx:</b> ${s.latenciaMax??'-'}</div>
  </div>`).join('');
};
const crear = async()=>{
  try{
    const body = { juego:$('#juego').value, formato:$('#formato').value,
      rangoMin:parseFloat($('#rangoMin').value), rangoMax:parseFloat($('#rangoMax').value),
      region:$('#region').value, latenciaMax:parseFloat($('#latenciaMax').value)};
    const d = await jsonFetch(EP.createScrim(), {method:'POST', body:JSON.stringify(body)});
    log('scrim creado: '+JSON.stringify(d)); $('#scrimId').value=d?.id||''; $('#accionScrimId').value=d?.id||'';
  }catch(e){ log('error crear → '+e.message); }
};
const listar = async()=>{ try{
  const d = await jsonFetch(EP.listScrims()); const arr = Array.isArray(d)?d:(d?.content||[]); render(arr); log('scrims listados');
}catch(e){ log('error listar → '+e.message);} };
const ver = async()=>{ const id=$('#scrimId').value.trim(); if(!id) return log('ingresá un id');
  try{ const d = await jsonFetch(EP.getScrim(id)); render([d]); log('ok ver '+id); }catch(e){ log('error ver → '+e.message);} };
const accion = async (tipo)=>{
  const id=$('#accionScrimId').value.trim(); if(!id) return log('ingresá un id');
  let url=EP[tipo](id); let opts={method:'POST'};
  if(tipo==='addPlayer'){ const nombre=$('#jugadorNombre').value.trim()||'jugador demo'; opts.body=JSON.stringify({nombre}); }
  try{ const d=await jsonFetch(url,opts); log(`${tipo} ok → ${JSON.stringify(d)}`);} catch(e){ log(`error ${tipo} → ${e.message}`); }
};
window.addEventListener('DOMContentLoaded',()=>{
  $('#apiBase').value=BASE; $('#saveConfig').onclick=()=>{ BASE=$('#apiBase').value.trim(); localStorage.setItem('apiBase',BASE); log('api base: '+BASE); };
  $('#btnCrear').onclick=crear; $('#btnListar').onclick=listar; $('#btnGet').onclick=ver;
  $('#btnAddPlayer').onclick=()=>accion('addPlayer'); $('#btnConfirm').onclick=()=>accion('confirm');
  $('#btnStart').onclick=()=>accion('start'); $('#btnFinish').onclick=()=>accion('finish'); $('#btnCancel').onclick=()=>accion('cancel');
  listar();
});
