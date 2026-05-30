/*
 * DSA Practice — Progress tracking.
 *
 * Auto-attaches a "mark passed" control to every problem row in any Masterclass
 * HTML that includes this script. State persists in localStorage, keyed by
 * topic path so arrays/twopointer/P01 and strings/twopointer/P01 don't collide.
 *
 * Include in each Masterclass with:
 *   <script src="../../util/progress.js" defer></script>
 */
(function () {
  'use strict';

  const STORE_KEY = 'dsa.progress.v1';

  function loadStore() {
    try { return JSON.parse(localStorage.getItem(STORE_KEY) || '{}'); }
    catch (e) { return {}; }
  }
  function saveStore(obj) {
    try { localStorage.setItem(STORE_KEY, JSON.stringify(obj)); } catch (e) {}
  }

  // Derive a topic namespace from the URL path so different topics keep
  // independent progress. Example: ".../src/arrays/twopointer/00_Masterclass.html"
  // becomes "arrays.twopointer".
  function topicNamespace() {
    const segs = location.pathname.split('/').filter(Boolean);
    if (segs.length < 2) return 'default';
    const dir = segs[segs.length - 2];
    const grand = segs.length >= 3 ? segs[segs.length - 3] : '';
    return grand && dir ? grand + '.' + dir : (dir || 'default');
  }

  const NS = topicNamespace();

  function fullKey(pid) { return NS + '.' + pid; }
  function isPassed(pid) { return !!loadStore()[fullKey(pid)]; }
  function setPassed(pid, on) {
    const s = loadStore();
    if (on) s[fullKey(pid)] = true;
    else delete s[fullKey(pid)];
    saveStore(s);
  }
  function togglePassed(pid) {
    const next = !isPassed(pid);
    setPassed(pid, next);
    return next;
  }

  // Find each row in the problem-index table by looking for anchors whose href
  // matches "P##_Something.html". Walk up to the enclosing <tr>.
  function discoverRows() {
    const seen = new Set();
    const out = [];
    document.querySelectorAll('a[href]').forEach(function (a) {
      const m = a.getAttribute('href').match(/^(P\d{2})_/);
      if (!m) return;
      const tr = a.closest('tr');
      if (!tr || seen.has(tr)) return;
      seen.add(tr);
      tr.dataset.pid = m[1];
      out.push(tr);
    });
    return out;
  }

  function injectStyles() {
    if (document.getElementById('dsa-progress-style')) return;
    const s = document.createElement('style');
    s.id = 'dsa-progress-style';
    s.textContent = [
      'tr.dsa-completed td { background: #dcfce7 !important; }',
      '.dsa-mark-btn {',
      '  cursor: pointer; padding: 1px 7px; margin-right: 6px;',
      '  border: 1px solid #cbd5e1; background: #f8fafc;',
      '  border-radius: 4px; font-size: .72rem; font-weight: 700;',
      '  color: #64748b; vertical-align: middle;',
      '}',
      '.dsa-mark-btn.on { background: #16a34a; color: #fff; border-color: #16a34a; }',
      '.dsa-progress-banner {',
      '  display: inline-block; background: #f0fdf4; border: 1px solid #bbf7d0;',
      '  border-radius: 999px; padding: 4px 14px; margin-top: 10px;',
      '  font-size: .85rem; font-weight: 600; color: #15803d;',
      '}',
      '.dsa-reset-link {',
      '  margin-left: 12px; font-size: .75rem; color: #64748b;',
      '  text-decoration: underline; cursor: pointer;',
      '}'
    ].join('\n');
    document.head.appendChild(s);
  }

  function applyState(tr, btn, on) {
    tr.classList.toggle('dsa-completed', on);
    btn.classList.toggle('on', on);
    btn.textContent = on ? '✓' : '○';
    btn.title = on
      ? 'Marked passed (click to unmark)'
      : 'Click when your Java tests all PASS';
  }

  function ensureBanner() {
    let banner = document.getElementById('dsa-progress-banner');
    if (banner) return banner;
    const header = document.querySelector('header');
    if (!header) return null;
    banner = document.createElement('div');
    banner.id = 'dsa-progress-banner';
    banner.className = 'dsa-progress-banner';
    const reset = document.createElement('span');
    reset.className = 'dsa-reset-link';
    reset.textContent = 'reset';
    reset.addEventListener('click', function () {
      if (!confirm('Clear progress for this topic?')) return;
      const s = loadStore();
      Object.keys(s).forEach(function (k) {
        if (k.startsWith(NS + '.')) delete s[k];
      });
      saveStore(s);
      location.reload();
    });
    header.appendChild(banner);
    header.appendChild(reset);
    return banner;
  }

  function updateBanner(rows) {
    const banner = ensureBanner();
    if (!banner) return;
    let passed = 0;
    rows.forEach(function (tr) { if (isPassed(tr.dataset.pid)) passed++; });
    banner.textContent = 'Progress: ' + passed + ' / ' + rows.length + ' completed';
  }

  function init() {
    injectStyles();
    const rows = discoverRows();
    if (!rows.length) return;
    rows.forEach(function (tr) {
      const pid = tr.dataset.pid;
      const firstTd = tr.querySelector('td');
      if (!firstTd) return;
      const btn = document.createElement('button');
      btn.className = 'dsa-mark-btn';
      btn.addEventListener('click', function (e) {
        e.preventDefault();
        const on = togglePassed(pid);
        applyState(tr, btn, on);
        updateBanner(rows);
      });
      firstTd.insertBefore(btn, firstTd.firstChild);
      applyState(tr, btn, isPassed(pid));
    });
    updateBanner(rows);
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', init);
  } else {
    init();
  }
})();
