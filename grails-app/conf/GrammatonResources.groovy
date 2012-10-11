modules = {

    grammaton {
        dependsOn 'jquery', 'cssreset', 'h5bp'
        resource plugin: 'grammaton', url: [dir: 'grammaton/js', file: 'grammaton.console-safe.js'], disposition: 'head'
        resource plugin: 'grammaton', url: [dir: 'grammaton/js', file: 'grammaton.spinner.js'], disposition: 'head'
    }

    cssreset {
        resource plugin: 'grammaton', url: [dir: 'grammaton/css', file: 'cssreset-min.css'], disposition: 'head', nominify: true
    }

    h5bp {
        dependsOn 'modernizr'
        resource plugin: 'grammaton', url: [dir: 'h5bp/css', file: 'normalize.css'], disposition: 'head'
        resource plugin: 'grammaton', url: [dir: 'h5bp/css', file: 'main.css'], disposition: 'head'
    }

}