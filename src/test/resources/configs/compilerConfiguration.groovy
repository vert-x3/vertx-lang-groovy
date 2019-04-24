package configs

import org.codehaus.groovy.control.customizers.ImportCustomizer

groovy {
    source.encoding = 'UTF-8'
    script.base = 'groovy.lang.Script'
}
customizer = { cConf ->
    def importCustomizer = new ImportCustomizer()
    importCustomizer.addImport('org.codehaus.groovy.control.CompilerConfiguration')
    cConf.addCompilationCustomizers(importCustomizer)
}
