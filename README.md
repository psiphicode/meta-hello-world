# hello-world
This repository implements a simple Yocto image with a custom layer. It is a yocto layer that demonstrates how to build an image with:
1. a c binary compiled at build time by the bitbake build system
2. a sysvinit init script that runs the binary on system boot
3. a custom layer that encapsulates the above functionality and
4. a custom image that uses the custom layer

The layer compiles the c binary from the included [hello_world.c](./files/hello_world.c) source, installs it in the image's `/usr/bin`, and uses the [hello-world-init](./files/hello-world-init) sysvinit script to install it as a startup service.

## Build Instructions
In a `poky` repository, use the following commands to build the image:
```sh
git clone https://github.com/psiphicode/meta-hello-world
source oe-init-build-env
bitbake hello-world-image
```
Now run the image using qemu:
```sh
runqemu hello-world-image kvm
```
It will print the hello world message and then present the user login prompt.
