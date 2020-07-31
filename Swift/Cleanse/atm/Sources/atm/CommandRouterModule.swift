//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 31/07/2020.
//

import Foundation
import Cleanse

struct CommandRouterModule : Module {
    
    typealias Scope = Unscoped
    
    static func configure(binder: Binder<Scope>) {
        binder
            .bind()
            .to(factory: CommandRouter.init)
    }
}
