# layer metadata
DESCRIPTION = "Simple Hello World binary"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# source files for this layer. necessary for `do_install:append()` to use them
SRC_URI = " \
    file://hello_world.c \
    file://hello-world-init \
    "

# specifies that source code will be extracted to the working directory
S = "${WORKDIR}"

# the update-rc.d class configures sysvinit scripts in a build-agnostic way
inherit update-rc.d
# use the filename, not the service name
INITSCRIPT_NAME = "hello-world"
# arguments to pass to the update-rc.d command
INITSCRIPT_PARAMS = "defaults"

# compile instructions for the c code
do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} -o hello_world hello_world.c
}

# instructions to install the init script and the binary to the image's filesystem
do_install:append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/hello-world-init ${D}${sysconfdir}/init.d/hello-world

    install -d ${D}${bindir}
    install -m 0755 hello_world ${D}${bindir}/hello_world
}

# the final package will contain the binary and the init script
FILES_${PN} = "${bindir}/hello_world ${sysconfdir}/init.d/hello-world"
