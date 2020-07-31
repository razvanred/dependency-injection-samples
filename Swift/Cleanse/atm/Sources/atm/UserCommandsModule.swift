//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 31/07/2020.
//

import Foundation
import Cleanse

struct UserCommandsModule : Module {
    
    static func configure(binder: UnscopedBinder) {
        binder.include(module: AmountsModule.self)
        
        binder
            .bind(Command.self)
            .intoCollection()
            .to(factory: DepositCommand.init)
        
        binder
            .bind(Command.self)
            .intoCollection()
            .to(factory: WithdrawCommand.init)
    }

}
