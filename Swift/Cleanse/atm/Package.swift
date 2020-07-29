// swift-tools-version:5.2
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "atm",
    dependencies: [
        .package(url: "https://github.com/square/Cleanse", from: "4.2.5"),
    ],
    targets: [
        // Targets are the basic building blocks of a package. A target can define a module or a test suite.
        // Targets can depend on other targets in this package, and on products in packages which this package depends on.
        .target(
            name: "atm",
            dependencies: ["Cleanse"]),
        .testTarget(
            name: "atmTests",
            dependencies: ["atm"]),
    ]
)
