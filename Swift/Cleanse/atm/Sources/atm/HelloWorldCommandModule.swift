//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation
import Cleanse

struct HelloWorldCommandModule : Module {
    
    static func configure(binder: UnscopedBinder) {
        binder
            .bind(Command.self)
            .to(factory: HelloWorldCommand.init)
    }
}
