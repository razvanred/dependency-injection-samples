//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation
import Cleanse

struct LoginCommandModule : Module {
    
    static func configure(binder: Binder<Unscoped>) {
        binder
            .bind(Command.self)
            .to(factory: LoginCommand.init)
    }
}
