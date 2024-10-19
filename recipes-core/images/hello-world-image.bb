# The custom image that includes the hello-world layer
SUMMARY = "Custom image with the Hello World binary"
LICENSE = "MIT"

inherit core-image

# BitBake registers the image with this name
IMAGE_NAME = "hello-world-image"

# Install the packagegroup-core-boot layer and the hello-world layer
IMAGE_INSTALL += "packagegroup-core-boot hello-world"
