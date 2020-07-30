//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 30/07/2020.
//

import Foundation
import Cleanse

struct DepositCommandModule : Module {
    
    static func configure(binder: Binder<Unscoped>) {
        binder
            .bind(Command.self)
            .intoCollection()
            .to(factory: DepositCommand.init)
    }
}
