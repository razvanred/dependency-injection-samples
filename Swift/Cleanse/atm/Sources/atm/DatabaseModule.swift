//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 30/07/2020.
//

import Foundation
import Cleanse

struct DatabaseModule : Module {
    
    static func configure(binder: Binder<Unscoped>) {
        binder
            .bind()
            .to(factory: Database.init)
    }
}
