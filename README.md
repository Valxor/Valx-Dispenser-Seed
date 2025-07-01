# Dispenser Seed Planter

🌱 **Automate your farming with intelligent seed dispensing!**

## 📖 Description

Transform your dispensers into smart farming tools! This mod allows dispensers to automatically plant seeds directly onto farmland blocks when activated by redstone, making your automated farms more efficient and realistic.

## ✨ Features

### 🚀 **Smart Seed Planting**
- Dispensers can now plant seeds directly on farmland instead of just dropping them
- Works with **all vanilla seeds**: Wheat, Carrots, Potatoes, Beetroot, Pumpkin, and Melon seeds

### 🌱 **Bone Meal Fertilization**
- Dispensers can automatically apply bone meal to fertilizable crops and plants
- Scans up to **6 blocks** in front of the dispenser for growable plants
- Includes particle effects and sound feedback for successful fertilization

### 🎯 **Intelligent Detection**
- Scans up to **6 blocks** in front of the dispenser
- Automatically detects valid farmland blocks for seeds
- Detects fertilizable crops and plants for bone meal
- Only plants on tilled soil with empty space above
- Sequential planting/fertilizing from closest to farthest block

### ⚡ **Redstone Activated**
- Only activates when the dispenser receives a redstone signal
- Perfect for automated farming systems
- Compatible with all existing redstone contraptions

### 🔊 **Audio Feedback**
- Plays planting sounds for each seed placed
- Plays fertilization sounds for each bone meal applied
- Dispenser activation sound when successful
- Falls back to normal item ejection if no valid targets found

## 🎮 How to Use

### 🌾 **Seed Planting**
1. **📦 Place a dispenser** facing your farmland
2. **🌾 Load seeds** into the dispenser inventory  
3. **🚜 Prepare farmland** - till soil with a hoe (up to 6 blocks away)
4. **⚡ Activate with redstone** - dispenser will automatically plant seeds!

### 🦴 **Bone Meal Fertilization**
1. **📦 Place a dispenser** facing your crops or plants
2. **🦴 Load bone meal** into the dispenser inventory
3. **🌱 Target fertilizable blocks** - crops, saplings, grass, etc.
4. **⚡ Activate with redstone** - dispenser will automatically fertilize!

## 🔧 Supported Items

### 🌾 **Seeds**
| Seed | Plants |
|------|--------|
| 🌾 Wheat Seeds | Wheat Crop |
| 🥕 Carrot | Carrot Crop |
| 🥔 Potato | Potato Crop |
| 🌱 Beetroot Seeds | Beetroot Crop |
| 🎃 Pumpkin Seeds | Pumpkin Stem |
| 🍉 Melon Seeds | Melon Stem |

### 🦴 **Fertilizer**
| Item | Effect |
|------|--------|
| 🦴 Bone Meal | Fertilizes crops, saplings, grass, flowers, and other growable plants |

## 📋 Requirements

- **Minecraft**: 1.21.6
- **Fabric Loader**: 0.16.14 or higher
- **Fabric API**: Required
- **Java**: 21 or higher

## 📥 Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 1.21.6
2. Download [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)
3. Place both Fabric API and this mod in your `mods` folder
4. Launch the game and enjoy automated farming!

## 🏗️ Perfect For

- **Automated Farms**: Create fully automatic crop production lines
- **Server Builds**: Reduce manual labor in multiplayer environments  
- **Redstone Engineers**: Add new functionality to your contraptions
- **Survival Players**: Streamline your food production

## 🔄 Example Setup

### 🌾 **Seed Planting Farm**
```
[Hopper] → [Dispenser] → [Farmland] → [Farmland] → [Farmland]...
              ↑
         [Redstone Clock]
```

### 🦴 **Bone Meal Fertilizer**
```
[Hopper] → [Dispenser] → [Crops] → [Crops] → [Crops]...
              ↑
         [Redstone Clock]
```

Connect a hopper to supply seeds or bone meal, add a redstone clock for automation, and watch your crops plant and grow themselves!

## 🐛 Bug Reports & Support

Found an issue? Please report it on the [GitHub Issues](https://github.com/your-username/valxdispenserseed/issues) page with:
- Minecraft version
- Mod version
- Steps to reproduce
- Screenshots/videos if applicable

## 📜 License

This mod is released under the CC0-1.0 License.

---

**Enjoy your automated farming! 🚜🌾**
