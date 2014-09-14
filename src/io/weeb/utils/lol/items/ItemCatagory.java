package io.weeb.utils.lol.items;

public enum ItemCatagory
{
	/* Physical */
	ATTACK_DAMAGE,
	LIFE_STEAL,
	CRITICAL_STRIKE,
	ATTACK_SPEED,
	ARMOR_PENETRATION, // TODO: YET TO BE IMPLEMENTED
	
	/* Magical */
	SPELL_DAMAGE,
	
	/* Health */
	HEALTH,
	HEALTH_REGEN,
	
	/* Mana */
	MANA,
	MANA_REGEN,
	
	/* Resistance */
	MAGIC_RESIST,
	ARMOR,
	
	/* Consumable */
	CONSUMABLE;
	
	public static ItemCatagory getItemCatagory(String raw)
	{
		switch(raw)
		{
		case "Damage":
			return ATTACK_DAMAGE;
		case "LifeSteal":
			return LIFE_STEAL;
		case "CriticalStrike":
			return CRITICAL_STRIKE;
		case "AttackSpeed":
			return ATTACK_SPEED;
		case "SpellDamage":
			return SPELL_DAMAGE;
		case "Health":
			return HEALTH;
		case "HealthRegen":
			return HEALTH_REGEN;
		case "Mana":
			return MANA;
		case "ManaRegen":
			return MANA_REGEN;
		case "Armor":
			return ARMOR;
		case "SpellBlock":
			return MAGIC_RESIST;
		case "Consumable":
			return CONSUMABLE;
		}
		
		System.out.println("Failed to find catagory: " + raw);
		return null;
	}
}
