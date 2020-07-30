//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 30/07/2020.
//

import Foundation
import Cleanse

struct DatabaseModule : Module {
    
    typealias Scope = Singleton
    
    static func configure(binder: Binder<Scope>) {
        binder
            .bind()
            .sharedInScope()
            .to(factory: Database.init)
    }
}
