(function() {
    var mainresource = document.querySelector('script[data-wrm-key="de.mola.jira.spielwiese.myplugin:main-react"]');
    var script = document.createElement('script');
    script.src = mainresource.src;
    document.getElementsByTagName('head')[0].appendChild(script);
    document.addEventListener('DOMContentLoaded', function (event) {
        window.loadedWPScriptAsync = true;
    });
})();