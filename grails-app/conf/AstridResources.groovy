modules = {

    astrid {
        dependsOn 'jquery', 'cssreset', 'h5bp'
        resource plugin: 'astrid', url: [dir: 'astrid/js', file: 'astrid.console-safe.js'], disposition: 'head'
        resource plugin: 'astrid', url: [dir: 'astrid/js', file: 'astrid.spinner.js'], disposition: 'head'
    }

    cssreset {
        resource plugin: 'astrid', url: [dir: 'astrid/css', file: 'cssreset-min.css'], disposition: 'head', nominify: true
    }

    h5bp {
        dependsOn 'modernizr'
        resource plugin: 'astrid', url: [dir: 'h5bp/css', file: 'normalize.css'], disposition: 'head'
        resource plugin: 'astrid', url: [dir: 'h5bp/css', file: 'main.css'], disposition: 'head'
    }

}